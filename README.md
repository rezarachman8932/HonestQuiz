# HonestQuiz

Basically, there are four layers in this project.
- Presentation layer
- ViewModel layer
- UseCase layer
- Repository

Presentation: To represent UI and view to the user. It can be activity or fragment. This layer must have no business logic and only have responsibility on view declaration.

ViewModel: Hold whole things that related with core logic and will be communicating with another layer. In this layer we can define any live data variables that bind into presentation layer.

UseCase: Independent layer that can be attached to any view model. The main function of this layer is to make our view model clean from repository access code implementation.

Repository: It consists of API, database, sharepreference, etc.


Tools
- Koin
- Coroutine
- Room

