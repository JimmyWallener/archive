Attached javafx.zip and jar_files.zip (opencsv with dependencies), which is needed to run the project.  
 In Intellij -> File -> Project Structure -> Libraries. Reference to Javafx/lib folder and with opencsv just reference to the folder itself - Apply and Close.
 Next step is Run -> Edit Config and add in VM Options:
 --module-path "Your Path to JavaFx\lib Folder" --add-modules=javafx.controls,javafx.fxml
 
 Now the project should run without problem.
 
 If you use any other IDE, then I suggest change to Intellij. /joking