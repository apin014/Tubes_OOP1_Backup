# Tubes_OOP_21
Clone this repository and inside the local directory type in:
```
cd Tubes_OOP_1
```

Once you've changed the directory, type this in to run the game and utilize the provided game configuration files:
```
.\gradlew.bat run --console=plain --args="\src\main\java\resources\elementEffectivity.csv \src\main\java\resources\movePool.csv \src\main\java\resources\monsterPool.csv"
```

Alternatively, you can also provide the path to your own configuration file (either move the config files to Tubes_OOP_1\app\src\main\java\resources or just provide the complete path to the files wherever they are located in your local drive), as long as you input it in the order of:
1. Element Effectivity config
2. Move config
3. Monster config