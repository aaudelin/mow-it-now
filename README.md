# mow-it-now

## Compatibilities
This program is available to Java 11 or above

## Compile process
```bash
git clone https://github.com/aaudelin/mow-it-now.git`
cd mow-it-now
mvn install
```

## Execution process
Go to the generated JAR file :
`java -jar mow-it-now-{version}.jar {absolute_file_path}`

The output file is available in `absolute_file_path` with `-output` suffix 

## Example
Instruction file :
```bash
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```

Standard output result :
```bash
java -jar mow-it-now-0.0.1-SNAPSHOT.jar /tmp/instructions-file
---- RESULT : Output mowers final position ---
1 3 N
5 1 E
```


