# RandomApiFaces

The project consist of 2 screens. 
1: List activity; 
2: Detailed activity

Remote Data is provided by: https://randomuser.me/

The List Activity consist of the RecyclerView with the recyclable View Holders. An Activity follows MVP pattern where all the business logic lives in the Presenter. Presenter is injected into the Activity via Google Dagger DI. Presenter makes a network call through Retrofit2 and it provides the remote data back to the Activity. Our activity persists the data during the orientation change.
The Presenter has unit tests coverage with Mockito Framework

The second Activity is pretty simple. It just shows an image and a little text. It has a UI Espresso test, which takes fake data via an Explicit Intent and verifies the correctness of the text.

The project is prepackaged by feature to accommodate Instant App support in the future.

To run all tests, please execute the following command in the Terminal: ./gradlew lint test cAT


