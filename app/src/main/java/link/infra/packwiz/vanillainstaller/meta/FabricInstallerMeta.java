package link.infra.packwiz.vanillainstaller.meta;

import java.util.List;

public class FabricInstallerMeta {
	private FabricInstallerMeta() {}

	// TODO: call fabric installer code
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
