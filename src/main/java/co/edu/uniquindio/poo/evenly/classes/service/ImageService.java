package co.edu.uniquindio.poo.evenly.classes.service;

import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageService {

    private static final String IMAGE_FOLDER =
            "storage/images";

    public String saveEventImage() {

        try {

            FileChooser fileChooser =
                    createFileChooser();

            File selectedFile =
                    fileChooser.showOpenDialog(null);

            if(selectedFile == null){

                return null;
            }

            File folder =
                    new File(IMAGE_FOLDER);

            if(!folder.exists()){

                folder.mkdirs();
            }

            String fileName =
                    System.currentTimeMillis()
                            + "_"
                            + selectedFile.getName();

            File destination =
                    new File(
                            folder,
                            fileName
                    );

            Files.copy(
                    selectedFile.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            return destination
                    .getAbsolutePath()
                    .replace("\\", "/");

        } catch (Exception e){

            throw new RuntimeException(
                    "Error al guardar la imagen"
            );
        }
    }

    private FileChooser createFileChooser(){

        FileChooser fileChooser =
                new FileChooser();

        fileChooser
                .getExtensionFilters()
                .add(

                        new FileChooser.ExtensionFilter(

                                "Imágenes",

                                "*.png",

                                "*.jpg",

                                "*.jpeg"
                        )
                );

        return fileChooser;
    }
}