elam-reader-be

User stories:

1. User story -> Show the List of books for a reader
   1. Filter a book repo based on reader id
   2. Show the data in the component -> Stored in Vuex store and integrated the API
2. Create a book assigned to a reader
   1. Create a POST API for creating reader and book and create foreign key based on reader and book(reader.reader_id=book.reader_id)
