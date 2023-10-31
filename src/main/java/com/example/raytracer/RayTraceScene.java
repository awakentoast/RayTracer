package com.example.raytracer;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.nio.ByteBuffer;

public class RayTraceScene {
    private final ImageView rayTraceView;
    private final WritableImage rayTraceImage;
    private final PixelWriter pixelWriter;
    private final PixelReader pixelReader;

    private final Camera camera;

    private int width;
    private int height;
    private final double aspectRatio = 16.0 / 9.0;

    public RayTraceScene(ImageView imageView) {
        this.rayTraceView = imageView;
        this.width = (int) imageView.getFitWidth();

        this.height = (int) (width / aspectRatio);
        height = Math.max(height, 1);
        imageView.setFitHeight(this.height);

        this.rayTraceImage = new WritableImage(width, height);
        this.pixelWriter = rayTraceImage.getPixelWriter();
        this.pixelReader = rayTraceImage.getPixelReader();

        this.camera = new Camera(1.0, 2.0, width, height);
    }

    public void writePixel(int x, int y, Color color) {
        pixelWriter.setColor(x, y, color);
        rayTraceView.setImage(rayTraceImage);
    }














    public void saveImageToFile() {
        File file = new File("images/image1");
        int bufferSize = (width * height * 4); // Each pixel is 4 bytes (RGBA)
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);

        pixelReader.getPixels(0, 0, width, height, PixelFormat.getByteBgraPreInstance(), buffer, (width * 4));

        try (FileWriter writer = new FileWriter(file)) {
            while (buffer.hasRemaining()) {
                int argb = buffer.getInt();

                int blue = (argb >> 16) & 0xFF;
                int green = (argb >> 8) & 0xFF;
                int red = (argb) & 0xFF;

                writer.write(STR. "\{ red } \{ green } \{ blue }\n" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
