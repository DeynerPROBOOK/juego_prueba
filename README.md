# 🎮 Juego de Personalidad — Java MVC

Un juego en Java que muestra rasgos de personalidad, usuarios y artefactos mediante ventanas emergentes. Desarrollado con el patrón Modelo-Vista-Controlador.

---

## 🗂️ Estructura del proyecto

```
proyecto/
├── src/
│   └── main/
│       └── java/
│           ├── Main.java          # Punto de entrada
│           ├── model/             # Datos y lógica del juego
│           ├── view/              # Lo que ve el usuario
│           └── controller/        # Conecta modelo y vista
├── bin/                           # Archivos compilados (se genera solo)
└── README.md
```

---

## ⚙️ Requisitos

- Java 21 o superior ([descargar aquí](https://adoptium.net/))
- VS Code (recomendado) o cualquier editor de texto

Para verificar que Java está instalado, abre la terminal y escribe:
```bash
java -version
```

---

## 🚀 Cómo ejecutar el proyecto

**1. Compilar:**
```bash
javac -d bin src/main/java/Main.java src/main/java/model/*.java src/main/java/controller/*.java src/main/java/view/*.java
```

**2. Ejecutar:**
```bash
java -cp bin Main
```

Al correr el programa aparecerán ventanas mostrando los rasgos de personalidad, los usuarios del sistema y los artefactos del juego.

---

## 📤 Subir cambios a GitHub

Primera vez (configuración inicial):
```bash
git init
git add .
git commit -m "Versión inicial"
git remote add origin https://github.com/tu-usuario/nombre-del-repo.git
git push -u origin main
```

Próximas actualizaciones:
```bash
git add .
git commit -m "Describe qué cambiaste"
git push
```

---
