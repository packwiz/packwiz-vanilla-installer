package link.infra.packwiz.vanillainstaller;

import net.fabricmc.installer.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

public class VanillaInstaller {

	private JFrame mainFrame;
	private JTextField packUrlField;
	private JLabel warningLabel;
	private JCheckBox checkboxInstallLoader;
	private JButton refreshVersionsButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				VanillaInstaller window = new VanillaInstaller();
				window.mainFrame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public VanillaInstaller() {
		initialize();
	}

	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setTitle("packwiz Vanilla Launcher installer");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel formContainer = new JPanel();
		mainFrame.getContentPane().add(formContainer, BorderLayout.CENTER);
		formContainer.setLayout(new BoxLayout(formContainer, BoxLayout.Y_AXIS));

		JLabel titleLabel = new JLabel("This installer creates an installation in the official Minecraft Launcher for a packwiz modpack.");
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		titleLabel.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
		formContainer.add(titleLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		formContainer.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel packUrlLabel = new JLabel("Pack URL");
		packUrlLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_packUrlLabel = new GridBagConstraints();
		gbc_packUrlLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_packUrlLabel.insets = new Insets(0, 0, 5, 5);
		gbc_packUrlLabel.gridx = 0;
		gbc_packUrlLabel.gridy = 0;
		panel.add(packUrlLabel, gbc_packUrlLabel);

		packUrlField = new JTextField();
		GridBagConstraints gbc_packUrlField = new GridBagConstraints();
		gbc_packUrlField.insets = new Insets(0, 0, 5, 5);
		gbc_packUrlField.fill = GridBagConstraints.HORIZONTAL;
		gbc_packUrlField.gridx = 1;
		gbc_packUrlField.gridy = 0;
		panel.add(packUrlField, gbc_packUrlField);
		packUrlField.setColumns(10);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridwidth = 3;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		panel.add(separator, gbc_separator);

		JLabel installationNameLabel = new JLabel("Installation name");
		installationNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_installationNameLabel = new GridBagConstraints();
		gbc_installationNameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_installationNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_installationNameLabel.gridx = 0;
		gbc_installationNameLabel.gridy = 2;
		panel.add(installationNameLabel, gbc_installationNameLabel);

		JTextField installationNameField = new JTextField();
		GridBagConstraints gbc_installationNameField = new GridBagConstraints();
		gbc_installationNameField.insets = new Insets(0, 0, 5, 5);
		gbc_installationNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_installationNameField.gridx = 1;
		gbc_installationNameField.gridy = 2;
		panel.add(installationNameField, gbc_installationNameField);
		installationNameField.setColumns(10);

		JLabel gameDirectoryLabel = new JLabel("Game directory");
		gameDirectoryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_gameDirectoryLabel = new GridBagConstraints();
		gbc_gameDirectoryLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_gameDirectoryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_gameDirectoryLabel.gridx = 0;
		gbc_gameDirectoryLabel.gridy = 3;
		panel.add(gameDirectoryLabel, gbc_gameDirectoryLabel);

		JTextField gameDirectoryField = new JTextField();
		GridBagConstraints gbc_gameDirectoryField = new GridBagConstraints();
		gbc_gameDirectoryField.insets = new Insets(0, 0, 5, 5);
		gbc_gameDirectoryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_gameDirectoryField.gridx = 1;
		gbc_gameDirectoryField.gridy = 3;
		panel.add(gameDirectoryField, gbc_gameDirectoryField);
		gameDirectoryField.setColumns(10);

		JButton gameDirectoryBrowseButton = new JButton("Browse...");
		GridBagConstraints gbc_gameDirectoryBrowseButton = new GridBagConstraints();
		gbc_gameDirectoryBrowseButton.insets = new Insets(0, 0, 5, 0);
		gbc_gameDirectoryBrowseButton.gridx = 2;
		gbc_gameDirectoryBrowseButton.gridy = 3;
		panel.add(gameDirectoryBrowseButton, gbc_gameDirectoryBrowseButton);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 10, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JButton gameDirectoryGeneratedPathButton = new JButton("Use generated path");
		GridBagConstraints gbc_gameDirectoryGeneratedPathButton = new GridBagConstraints();
		gbc_gameDirectoryGeneratedPathButton.insets = new Insets(0, 0, 0, 5);
		gbc_gameDirectoryGeneratedPathButton.gridx = 1;
		gbc_gameDirectoryGeneratedPathButton.gridy = 0;
		panel_1.add(gameDirectoryGeneratedPathButton, gbc_gameDirectoryGeneratedPathButton);

		JButton gameDirectoryUseMcFolderButton = new JButton("Use .minecraft");
		GridBagConstraints gbc_gameDirectoryUseMcFolderButton = new GridBagConstraints();
		gbc_gameDirectoryUseMcFolderButton.insets = new Insets(0, 0, 0, 5);
		gbc_gameDirectoryUseMcFolderButton.gridx = 3;
		gbc_gameDirectoryUseMcFolderButton.gridy = 0;
		panel_1.add(gameDirectoryUseMcFolderButton, gbc_gameDirectoryUseMcFolderButton);

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 5;
		panel.add(separator_1, gbc_separator_1);

		JLabel modLoaderLabel = new JLabel("Mod loader");
		modLoaderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_modLoaderLabel = new GridBagConstraints();
		gbc_modLoaderLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_modLoaderLabel.insets = new Insets(0, 0, 5, 5);
		gbc_modLoaderLabel.gridx = 0;
		gbc_modLoaderLabel.gridy = 6;
		panel.add(modLoaderLabel, gbc_modLoaderLabel);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 6;
		panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton radioButtonFabric = new JRadioButton("Fabric");
		buttonGroup.add(radioButtonFabric);
		panel_3.add(radioButtonFabric);

		JRadioButton radioButtonForge = new JRadioButton("Forge");
		buttonGroup.add(radioButtonForge);
		panel_3.add(radioButtonForge);

		JRadioButton radioButtonOther = new JRadioButton("Other");
		buttonGroup.add(radioButtonOther);
		panel_3.add(radioButtonOther);

		checkboxInstallLoader = new JCheckBox("Install loader");
		checkboxInstallLoader.setSelected(true);
		GridBagConstraints gbc_checkboxInstallLoader = new GridBagConstraints();
		gbc_checkboxInstallLoader.insets = new Insets(0, 0, 5, 0);
		gbc_checkboxInstallLoader.gridx = 2;
		gbc_checkboxInstallLoader.gridy = 6;
		panel.add(checkboxInstallLoader, gbc_checkboxInstallLoader);

		JLabel minecraftVersionLabel = new JLabel("Minecraft version");
		minecraftVersionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_minecraftVersionLabel = new GridBagConstraints();
		gbc_minecraftVersionLabel.anchor = GridBagConstraints.EAST;
		gbc_minecraftVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_minecraftVersionLabel.gridx = 0;
		gbc_minecraftVersionLabel.gridy = 7;
		panel.add(minecraftVersionLabel, gbc_minecraftVersionLabel);

		JComboBox<String> minecraftVersionComboBox = new JComboBox<>();
		GridBagConstraints gbc_minecraftVersionComboBox = new GridBagConstraints();
		gbc_minecraftVersionComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_minecraftVersionComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_minecraftVersionComboBox.gridx = 1;
		gbc_minecraftVersionComboBox.gridy = 7;
		panel.add(minecraftVersionComboBox, gbc_minecraftVersionComboBox);

		refreshVersionsButton = new JButton("Refresh");
		GridBagConstraints gbc_refreshVersionsButton = new GridBagConstraints();
		gbc_refreshVersionsButton.insets = new Insets(0, 0, 5, 0);
		gbc_refreshVersionsButton.gridx = 2;
		gbc_refreshVersionsButton.gridy = 7;
		panel.add(refreshVersionsButton, gbc_refreshVersionsButton);

		JLabel loaderVersionLabel = new JLabel("Fabric Loader version");
		loaderVersionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_loaderVersionLabel = new GridBagConstraints();
		gbc_loaderVersionLabel.anchor = GridBagConstraints.EAST;
		gbc_loaderVersionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loaderVersionLabel.gridx = 0;
		gbc_loaderVersionLabel.gridy = 8;
		panel.add(loaderVersionLabel, gbc_loaderVersionLabel);

		JComboBox<String> loaderVersionComboBox = new JComboBox<>();
		GridBagConstraints gbc_loaderVersionComboBox = new GridBagConstraints();
		gbc_loaderVersionComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_loaderVersionComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_loaderVersionComboBox.gridx = 1;
		gbc_loaderVersionComboBox.gridy = 8;
		panel.add(loaderVersionComboBox, gbc_loaderVersionComboBox);

		JLabel refreshHintLabel = new JLabel("Can't see the version you want? Try running it in the launcher first, then hit refresh.");
		GridBagConstraints gbc_refreshHintLabel = new GridBagConstraints();
		gbc_refreshHintLabel.gridwidth = 3;
		gbc_refreshHintLabel.insets = new Insets(0, 0, 5, 0);
		gbc_refreshHintLabel.gridx = 0;
		gbc_refreshHintLabel.gridy = 9;
		panel.add(refreshHintLabel, gbc_refreshHintLabel);

		Component glue = Box.createGlue();
		GridBagConstraints gbc_glue = new GridBagConstraints();
		gbc_glue.fill = GridBagConstraints.VERTICAL;
		gbc_glue.insets = new Insets(0, 0, 5, 5);
		gbc_glue.gridx = 1;
		gbc_glue.gridy = 10;
		panel.add(glue, gbc_glue);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 11;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setBorder(new TitledBorder(null, "Advanced options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		JLabel launcherPathLabel = new JLabel("Launcher path");
		GridBagConstraints gbc_launcherPathLabel = new GridBagConstraints();
		gbc_launcherPathLabel.insets = new Insets(0, 0, 5, 5);
		gbc_launcherPathLabel.anchor = GridBagConstraints.EAST;
		gbc_launcherPathLabel.gridx = 0;
		gbc_launcherPathLabel.gridy = 0;
		panel_2.add(launcherPathLabel, gbc_launcherPathLabel);

		JTextField launcherPathField = new JTextField();
		GridBagConstraints gbc_launcherPathField = new GridBagConstraints();
		gbc_launcherPathField.insets = new Insets(0, 0, 5, 5);
		gbc_launcherPathField.fill = GridBagConstraints.HORIZONTAL;
		gbc_launcherPathField.gridx = 1;
		gbc_launcherPathField.gridy = 0;
		panel_2.add(launcherPathField, gbc_launcherPathField);
		launcherPathField.setColumns(10);

		JButton launcherPathBrowseButton = new JButton("Browse...");
		GridBagConstraints gbc_launcherPathBrowseButton = new GridBagConstraints();
		gbc_launcherPathBrowseButton.insets = new Insets(0, 0, 5, 0);
		gbc_launcherPathBrowseButton.gridx = 2;
		gbc_launcherPathBrowseButton.gridy = 0;
		panel_2.add(launcherPathBrowseButton, gbc_launcherPathBrowseButton);

		JLabel createdVersionNameLabel = new JLabel("Created version name");
		GridBagConstraints gbc_createdVersionNameLabel = new GridBagConstraints();
		gbc_createdVersionNameLabel.anchor = GridBagConstraints.EAST;
		gbc_createdVersionNameLabel.insets = new Insets(0, 0, 0, 5);
		gbc_createdVersionNameLabel.gridx = 0;
		gbc_createdVersionNameLabel.gridy = 1;
		panel_2.add(createdVersionNameLabel, gbc_createdVersionNameLabel);

		JTextField createdVersionNameField = new JTextField();
		GridBagConstraints gbc_createdVersionNameField = new GridBagConstraints();
		gbc_createdVersionNameField.insets = new Insets(0, 0, 0, 5);
		gbc_createdVersionNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_createdVersionNameField.gridx = 1;
		gbc_createdVersionNameField.gridy = 1;
		panel_2.add(createdVersionNameField, gbc_createdVersionNameField);
		createdVersionNameField.setColumns(10);

		JPanel bottomBarContainer = new JPanel();
		mainFrame.getContentPane().add(bottomBarContainer, BorderLayout.SOUTH);
		bottomBarContainer.setLayout(new BorderLayout(0, 0));

		JPanel nextButtonContainer = new JPanel();
		FlowLayout fl_nextButtonContainer = (FlowLayout) nextButtonContainer.getLayout();
		fl_nextButtonContainer.setAlignment(FlowLayout.RIGHT);
		bottomBarContainer.add(nextButtonContainer, BorderLayout.EAST);

		JButton nextButton = new JButton("Next");
		nextButtonContainer.add(nextButton);

		JPanel warningLabelContainer = new JPanel();
		bottomBarContainer.add(warningLabelContainer, BorderLayout.CENTER);
		warningLabelContainer.setLayout(new BorderLayout(0, 0));

		warningLabel = new JLabel("Pack URL is required");
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setForeground(new Color(204, 0, 51));
		warningLabelContainer.add(warningLabel);

		JPanel exitButtonContainer = new JPanel();
		bottomBarContainer.add(exitButtonContainer, BorderLayout.WEST);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> mainFrame.dispose());
		exitButtonContainer.add(exitButton);

		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);

		// TODO: load defaults and retrieved values
		// - set launcher path to .minecraft folder
		// - set created version name to same as installation name? (unless modified by user)
		// - set game directory from install name (unless modified by user)
		// - when pack URL is added, use metadata to populate install name, mod loader, mc version, loader version, etc.
		// - set default pack URL to one appended to .jar?
		//   - then a webpage can be used to append them and give the user a customised jar (or .exe with fabric-installer-native-bootstrap)

		// TODO: implement browse buttons
		// TODO: implement generated path / .minecraft buttons
		// - warn if any path (other than .minecraft) already exists
		// - warn if mods folder or packwiz.json in .minecraft is non-empty?
		// TODO: implement refresh button

		// TODO: when Fabric selected:
		// - when install loader checked; list all minecraft + fabric loader versions (snapshots checkbox?)
		// - when install loader checked, hide the "can't see the version you want" text
		// - when install loader unchecked, display a list of installed versions

		// TODO: when Forge selected:
		// - display a list of installed versions, ideally filtered by Forge and minecraft version?
		// - display a link to download the Forge installer

		// TODO: when None selected:
		// - display a list of installed versions

		// - could display the loader and minecraft versions used by the pack even when not automatically installing

		// TODO: implement next page (with install progress label + spinner)
		// TODO: error display
		// TODO: self version check?

		nextButton.addActionListener(e -> {
			try {
				Main.main(new String[]{});
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});

		launcherPathField.setText(PathUtils.getMinecraftPath().toString());
		gameDirectoryGeneratedPathButton.addActionListener(e -> {
			// TODO: when empty, make error dialog
			gameDirectoryField.setText(PathUtils.getGeneratedPath(installationNameField.getText()).toString());
		});
		gameDirectoryUseMcFolderButton.addActionListener(e -> {
			gameDirectoryField.setText(launcherPathField.getText());
		});
	}
}
