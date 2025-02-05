### Design approach for any system:
Identify modular components in the system.
Identify how different components are related to each other.
Identify the conversation between the components.

So system can talk to either in req/response or using Events(EDA)

EDA provides loosely coupled/Async system where the expectation with system is eventually consistent.

https://www.youtube.com/watch?v=UStWv62FX-k&list=PLa7VYi0yPIH0IpUKXb3q7NSjpJGO9GGGZ&index=2
https://www.youtube.com/watch?v=AEbJgpamZ4w

### Use SAGA pattern when the commands span over multiple services
### Use CQRS pattern when the Query spans over multiple services.
