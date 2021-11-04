package link.infra.packwiz.vanillainstaller.meta;

import java.awt.*;
import java.net.URI;

public class PackMetadataRetriever {
	private URI packUri = null;
	private Data data = null;

	/**
	 * @return True when new data was fetched
	 */
	public boolean update(URI packUri) {
		assert EventQueue.isDispatchThread();

		if (!packUri.equals(this.packUri)) {
			data = null;

			// TODO: start swingworker, extract data
			// TODO: mechanisms for progress/result

			return true;
		}

		return false;
	}

	public Data getData() {
		return data;
	}

	public static class Data {
		// TODO: name, mod loader, mc version, loader version, parsed toml file, validity (throw error if not valid or too new/old)

		private Data() {}
	}

}
