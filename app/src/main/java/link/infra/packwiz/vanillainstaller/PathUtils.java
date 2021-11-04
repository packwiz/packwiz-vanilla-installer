package link.infra.packwiz.vanillainstaller;

import net.fabricmc.installer.util.Utils;

import java.nio.file.Path;
import java.util.Locale;

public class PathUtils {
	private PathUtils() {}

	public static Path getMinecraftPath() {
		return Utils.findDefaultInstallDir();
	}

	public static Path getGeneratedPath(String packName) {
		return getMinecraftPath().resolve("packwiz-packs").resolve(slugify(packName));
	}

	private static String slugify(String packName) {
		return packName.toLowerCase(Locale.ROOT)
			.replace(' ', '-')
			.replaceAll("[\\x00-\\x1F\\x7F\"*/:<>?\\\\|\\[\\]]", "-")
			.replaceAll("-+", "-")
			.replaceAll("^-|-$", "");
	}
}
