package objects;

/**
 * Created by Adam on 7/24/2016.
 */
public class EntryFormatter {

    private Entry entry;

    public EntryFormatter(){

    }

    public EntryFormatter(Entry entry){
        this.entry = entry;
    }

    public void format(Entry entry){

        parseName(entry);


            try {
                String temp = entry.getFirstName();
                System.out.println(temp);
                String number = temp.substring(temp.indexOf(" ")).trim();
                String firstName = temp.substring(0, temp.indexOf(" "));
                entry.setFirstName(firstName);
                entry.setPhoneNumber(entry.getPhoneNumber().length() > 2 ? entry.getPhoneNumber() + " " + number : number);
            }

            catch (Exception e){
                return; // Returns if the entry is legal.
            }




    }

    private void parseName(Entry entry){
        String name = entry.getFirstName().trim();
        try {
            entry.setFirstName(name.substring(name.indexOf(",") + 1).trim());
            entry.setLastName(name.substring(0, name.indexOf(",")).trim());
        }
        catch(StringIndexOutOfBoundsException e){
            try{
                entry.setFirstName(name.substring(name.indexOf(" ") + 1).trim());
                entry.setLastName(name.substring(0, name.indexOf(" ")).trim());
            }
            catch(StringIndexOutOfBoundsException e2){
                entry.setFirstName(name);
                entry.setLastName("No Last Name Listed");
            }
        }
    }

}
