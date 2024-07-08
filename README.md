Simple Android App using Retrofit, MVVM, Dagger, and LiveData
This Android app demonstrates fetching and displaying a list of items from a remote JSON API using Retrofit, implementing MVVM architecture, Dagger for dependency injection, and LiveData for observing data changes.

**Features:**
1. Fetches data from https://fetch-hiring.s3.amazonaws.com/hiring.json using Retrofit.
2. Implements MVVM architecture for separation of concerns.
3. Uses Dagger Hilt for dependency injection to provide Retrofit service and ViewModel dependencies.
4. Displays fetched items grouped by listId and sorted by listId and name.
5. Filters out items with blank or null name fields.
6. Displays the list in a RecyclerView with a simple adapter.
**Components Used**
1. Retrofit: For making network requests and parsing JSON responses.
2. Gson Converter: To convert JSON response to Kotlin objects.
3. Dagger: For dependency injection to manage dependencies in the app.
4. ViewModel and LiveData: For managing UI-related data in a lifecycle-conscious way.
5. RecyclerView: To display a list of items efficiently.
