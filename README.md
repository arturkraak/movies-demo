<h1 align="center">🛠️Technologies used</h1>


<div align="center">

| [Technology](https://www.youtube.com/watch?v=hdHBCu3tv24) | __Version__  | __Description__ |
| :---: | :---: | :---: |
| [Java](https://www.oracle.com/java/technologies/downloads/#jdk21-windows)  | 21.0.2 2024-01-16 LTS | Programming Language |
| [IntelliJ IDEA](https://www.jetbrains.com/idea/)  |  2023.3.6 (Ultimate Edition) | Integrated Development Environment |
| [Spring Boot](https://spring.io/projects/spring-boot) | 3.2.3 (Gradle - Groovy) | Java Framework |
| [PostgreSQL](https://www.postgresql.org/) | 16 | Object-Relational Database |
| [Thymeleaf](https://www.thymeleaf.org/) | 3.1.2 | HTML Templating for Java |
| [Bootstrap](https://getbootstrap.com/) | 5.3.3 | Frontend Toolkit |
| [HTMX](https://htmx.org/) | 1.9.11 | Frontend Framework |

### Live Demo running on a Raspberry Pi 4 (using nginx proxy):
### [https://arturkraak.duckdns.org/cinema/](https://arturkraak.duckdns.org/cinema/)

# Features
| Feature | Completion |
| :---: | :---: |
| Filter Movies By Name & Genre | ✅ |
| Movie Schedule | ❌ |
| Movie Recommendations | ❌ |
| Seat Recommendation | ❌ |
| Docker | ✅ |


# Instructions (PowerShell):
</div>

```powershell
git clone https://github.com/arturkraak/movies-demo.git
cd movies-demo
./gradlew bootJar
docker compose up
```
http://localhost:8081/cinema/



