Then open IntelliJ IDEA and from the `File` menu choose `Open`, then select the `build.gradle` file from the `exercises\java` directory.

When prompted, choose to `Open as project`. IntelliJ should download all the dependencies required, and you should end up with no problems.

IntelliJ now defaults to running tests using Gradle. You can change this by opening up the Gradle panel, clicking the spanner icon and changing `Build and run using` and `Run tests using` to `IntelliJ IDEA`. This will give you slightly nicer output.

Validate that you are set up correctly by running the tests. Right click the `src\test` directory and choose `Run 'All Tests'`.