# Binder IPC Demo Using AIDL – Squid Game Edition

This project demonstrates Inter-Process Communication (IPC) in Android using Binder and AIDL, themed around Squid Game. Imagine each app as a player, the AIDL file as the game rulebook, and Binder as the masked referee enforcing communication rules across boundaries.

---

## Project Structure
```agsl
binder-aidl-demo/
├── commonmathlib/src/main/aidl/vendor/math         # Shared AIDL interface (game rulebook)
│   └── IMathAreaCalculator.aidl
├── commonmathservice/src/main/vendor/math/service     # Service app (masked game referee)
│   ├── MathAreaService.kt
│   └── IMathAreaServiceImpl.kt
├── MathLibraryApp/src/main/java/vendor/math/app        # Client app (game player)
│   └── MainActivity.kt

```

---

## Concept Overview

In Android, each app runs in a sandboxed process. To communicate across these process boundaries, Android uses the Binder IPC mechanism. The Android Interface Definition Language (AIDL) allows developers to define structured interfaces for this communication.

- commonmathlib: Defines the AIDL interface IMathAreaCalculator.
- commonmathservice: Hosts a bound service that implements the interface and performs area calculations.
- MathLibraryApp: A client that connects to the service and makes IPC calls.

---

## How to Run

1. Clone the repository:
   git clone https://github.com/mohamedrashik/AIDL-binder-demo.git

2. Open the project in Android Studio.

3. Build and install the apps in the following order:
    - commonmathlib
    - commonmathservice (install and run first)
    - MathLibraryApp (install and run after the service)

Note: Make sure both apps are installed on the same device and signed with the same debug or release key.

---

## AIDL Interface

 IMathAreaCalculator.aidl
```java
interface IMathAreaCalculator {
    /**
     * Calculates the area of a square.
     * @param side Length of the square's side.
     * @return Area of the square.
     */
    int calculateSquareArea(int side);

    /**
     * Calculates the area of a rectangle.
     * @param length Length of the rectangle.
     * @param width Width of the rectangle.
     * @return Area of the rectangle.
     */
    int calculateRectangleArea(int length, int width);

    /**
     * Calculates the area of a triangle.
     * @param base Base of the triangle.
     * @param height Height of the triangle.
     * @return Area of the triangle.
     */
    int calculateTriangleArea(int base, int height);

    /**
     * Calculates the area of a circle.
     * Uses integer approximation of π = 3.
     * @param radius Radius of the circle.
     * @return Area of the circle.
     */
    int calculateCircleArea(int radius);

    /**
     * Returns the name of the service.
     * @return The service name.
     */
    String getServiceName();
}
```

AIDL automatically generates boilerplate code for IPC, converting method calls into Parcel objects under the hood.

---

## Features

- Demonstrates real-world AIDL + Binder usage
- Cross-process communication example
- Themed learning using Squid Game
- Teaches service binding, marshalling, and AIDL contracts

---

## Security Tips

While this project is built for learning:
- Avoid exporting services without protection
- Validate incoming data
- Use permissions if needed for production apps

---

## References

- Android Developers – AIDL: https://developer.android.com/guide/components/aidl
- Android Binder Internals: https://source.android.com/docs/core/architecture/hidl/binder-ipc

---

## License

This project is licensed under the MIT License.
Feel free to use and modify it for educational or personal projects.

---

## Contributions

Pull requests and suggestions are welcome.
Raise an issue or PR to improve or expand this Squid-Game-inspired IPC demo.
