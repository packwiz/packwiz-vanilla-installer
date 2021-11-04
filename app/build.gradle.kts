plugins {
	application
}

repositories {
	mavenCentral()

	maven {
		name = "Fabric"
		url = uri("https://maven.fabricmc.net/")
	}
}

dependencies {
	// TODO: display license information in app
	// TODO: shade deps
	implementation("net.fabricmc:fabric-installer:0.9.0")
}

application {
	mainClass.set("link.infra.packwiz.vanillainstaller.VanillaInstaller")
}

// TODO: META-INF
// TODO: build fabric-installer-native-bootstrap .exe