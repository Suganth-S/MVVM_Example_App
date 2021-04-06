# MVVM_Example_App

### Why Design Patterns ?

1. Makes the code more understandable
2. Makes code maintainable for long run
3. Make project loosely coupled
4. Makes code testable
5. Make changes, add features easily

### Architectural principles

1. Seperation of Concerns
    Basically we write our codes in activity and fragments, basically its worst case, our fragment or activity ony contain UI related logics, one of common problem we always facing is , when we use Retrofit , when we update by fetching some data from the fragment, the application will get crashed. Becoz we doesn.t own activity or fragments, so android destroy it anytime because of its needs. Ex : In case of low memory.

2. Drive UI from Model

### Why MVVM ?

Recommends by google, and so there is no perfect architure to get rid of all our issues, selecting a pattern it completely depends on project needs

## Repositories :

1. It handles data operations.
2. It is a clean way to provide distinction between how an application retrieves data, and how it uses / displays the data
3. Repository known where to get data, and when to update data using API calls
4. You can consider repositories to be mediators between different data sources, such as persistent models, web services, and caches.

## View Model:

1. It's a model, for a view.
2. The view can be fragment or activity, and model can be anything
3. View Model tell other component to retrieve data, and handle incoming request from user.
4. It seperates the act of retrieving or updating data sets, and current state of UI.
5. It's only concern is holding a accurate reference to the data for the view.
6.  If the user was to close the app and reopen it several hours later, they would see exactly the same thing as when they closed it.

## LiveData :

1. It is an observable-data holder class
2. Responsible for holding the data that's displayed in the view
3. It's not just any old data-holder, it's an observables.
4. Meaning that, the data is actively being watched for changes, if a change occurs , the view is updated automatically.
5. MutableLiveData - to allow LiveData Object to be changed.
6. ViewModel will not be destroyed if its owner is destroyed for a configuration change (the owner being the activity or fragment its existed in).
7. The new instance of the owner will just re-connected to the existing ViewModel. So if the user locks the phone screen and comes back several hours later they're still going to see the exact same thing.
