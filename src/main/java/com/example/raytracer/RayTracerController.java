package com.example.raytracer;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

public class RayTracerController {

    @FXML
    private ImageView rayTraceSceneImageView;

    private RayTraceScene rayTraceScene;


    private int imageWidth;
    private int imageHeight;

    private void drawRayTraceScene() throws InterruptedException {
        Color color;

        for (int i = 0; i < imageHeight; i++) {
            System.out.format("ScanLines remaining: %d%n", imageHeight - i);
            for (int j = 0; j < imageWidth; j++) {
                double r = ((double) j / (imageWidth - 1));
                double g =   ((double) i / (imageHeight - 1));
                int b = 0;

                color = new Color(r, g, b,1);
                rayTraceScene.writePixel(j,i,color);
            }
        }

        rayTraceScene.saveImageToFile();
    }


    public void initialize() {
        imageWidth = (int) rayTraceSceneImageView.getFitWidth();
        imageHeight = (int) rayTraceSceneImageView.getFitHeight();

        rayTraceScene = new RayTraceScene(rayTraceSceneImageView);

        // Create a Task for ray tracing
        Task<Void> rayTraceTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                drawRayTraceScene(); // Call your ray tracing method here
                return null;
            }
        };

        // Start the ray tracing task
        new Thread(rayTraceTask).start();
    }
}