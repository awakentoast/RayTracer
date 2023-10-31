package com.example.raytracer;

public class Camera {

    private double focalLength;
    private double viewportHeight;
    private double viewportWidth;

    private CustomPoint3D cameraCenter = new CustomPoint3D(0, 0, 0);

    private CustomPoint3D horizontalViewport;
    private CustomPoint3D verticalViewport;

    private double horizontalPixelDelta;
    private double verticalPixelDelta;

    private CustomPoint3D viewportUpperLeft;

    public Camera(double focalLength, double viewportHeight, int imageWidth, int imageHeight) {
        this.focalLength = focalLength;
        this.viewportHeight = viewportHeight;
        this.viewportWidth = viewportHeight * ((double) imageWidth / imageHeight);

        this.horizontalViewport = new CustomPoint3D(this.viewportWidth, 0, 0);
        this.verticalViewport = new CustomPoint3D(0, -this.viewportHeight, 0);

        this.horizontalPixelDelta = this.horizontalViewport.getX() / imageWidth;
        this.verticalPixelDelta = Math.abs(this.verticalViewport.getY() / imageHeight);

        this.viewportUpperLeft = (CustomPoint3D) this.cameraCenter.subtract(0, 0, this.focalLength)
                .subtract(horizontalViewport.multiply(0.5))
                .subtract(verticalViewport.multiply(0.5));

    }
}
