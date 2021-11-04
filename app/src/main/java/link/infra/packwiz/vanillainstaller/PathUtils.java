package link.infra.packwiz.vanillainstaller;

import java.nio.file.Path;
import java.util.Locale;

public class PathUtils {
	private PathUtils() {}

	public static Path getMinecraftPath() {
		// TODO: stub
		throw new UnsupportedOperationException();
	}

	public static Path getGeneratedPath(String packName) {
		// TODO: .minecraft/packwiz-packs/pack-name-here (append -1/etc. if it already exists)
		throw new UnsupportedOperationException();
	}

	private static String slugify(String packName) {
		return packName.toLowerCase(Locale.ROOT)
			.replace(' ', '-')
			.replaceAll("[\\x00-\\x1F\\x7F\"*/:<>?\\\\|]", "")
			.replaceAll("-+", "-")
			.replaceAll("^-|-$", "");
	}
}
