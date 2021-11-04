package link.infra.packwiz.vanillainstaller.meta;

import java.util.List;

public class FabricInstallerMeta {
	private FabricInstallerMeta() {}

	// TODO: how will I run the installer? is it usable as a library, or simpler to just download the jar at runtime and use the CLI?
	// TODO: could run off-thread with a swingworker?

	// Using Fabric's API for this ensures we don't get versions unsupported by Fabric
	public List<String> getMinecraftVersions(boolean stableOnly) {
		// TODO: stub
		throw new UnsupportedOperationException();
	}

	public List<String> getFabricLoaderVersions() {
		// TODO: stub
		throw new UnsupportedOperationException();
	}
}
