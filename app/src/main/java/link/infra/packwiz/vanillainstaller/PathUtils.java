package link.infra.packwiz.vanillainstaller;

import net.fabricmc.installer.util.Utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class PathUtils {
	private PathUtils() {}

	private static final String os = System.getProperty("os.name").toLowerCase();

	public static Path getMinecraftPath() {
		return Utils.findDefaultInstallDir();
	}

	public static Path getPackwizUserPath() {
		if (os.contains("win")){
			return Paths.get(System.getenv("APPDATA")).resolve("packwiz");
		} else if (os.contains("mac")) {
			return Paths.get(System.getProperty("user.home")).resolve("Library").resolve("Application Support").resolve("packwiz");
		} else {
			// TODO: a better location on linux?
			return Paths.get(System.getProperty("user.home")).resolve("packwiz");
		}
	}

	public static Path getPackwizInstancesPath() {
		return getPackwizUserPath().resolve("instances");
	}

	public static Path getGeneratedPath(String packName) {
		return getPackwizInstancesPath().resolve(slugify(packName));
	}

	private static String slugify(String packName) {
		return packName.toLowerCase(Locale.ROOT)
			.replace(' ', '-')
			.replaceAll("[\\x00-\\x1F\\x7F\"*/:<>?\\\\|\\[\\]]", "-")
			.replaceAll("-+", "-")
			.replaceAll("^-|-$", "");
	}
}
