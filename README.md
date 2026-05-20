<img width="1378" height="990" alt="Lab3SS" src="https://github.com/user-attachments/assets/b4c50aa3-50d6-4667-b65e-a8c4168a2b92" />
# Lab3BouncyCube3D
## Ce face aplicatia
Afiseaza un cub 3D care se misca sus-jos si se roteste pe axele X si Y.

## Cerinte implementate
- proiect `BouncyCube`
- package `cg.bouncycube`
- `BouncyCubeActivity`
- `Cube`
- `CubeRenderer`
- cub 3D definit prin 8 vertex-uri
- culori pentru vertex-uri
- doua triangle fans
- `glDrawElements` cu `GL_TRIANGLE_FAN`
- translatie pe Z la `-7.0f`
- animatie verticala cu `Math.sin`
- rotatie pe axa X
- rotatie pe axa Y
- `glScalef(1.0f, 2.0f, 1.0f)`
- frustum cu FOV 30 grade
- `zNear = 0.1f`
- `zFar = 1000.0f`
- backface culling
- depth testing
