docker build -t anyName .
Для исопльзования параметра DEPENDENCY ипользовать следующую команду:
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
docker run -p 8081:8081
