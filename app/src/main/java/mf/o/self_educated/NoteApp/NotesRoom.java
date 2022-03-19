package mf.o.self_educated.NoteApp;


public class NotesRoom {

    private String title1 ;
    private  String input_notes1;

public NotesRoom (String title , String input_notes) {
  title1 = title;
  input_notes1 = input_notes;

}// NotesRoom cons

public String getTitle() {
     return title1;
    }// getTitle

public  String getInput_notes(){
    return input_notes1;
}// getInput_notes


}// End of NotesRoom class
