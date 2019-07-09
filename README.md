This is the coding test for Poq - a few notes on the project:
* The requirement was only to show a list, but I've taken the extra set to have a display screen (with some basic informaion on the repository)
* It's 100% Kotlin, using Coroutines rather than Rx for Retrofit calls
* Within the RepoDisplayFragment I tried using the synthetic import, but it kept throwing null pointer errors, so I've built a TextView utils file
