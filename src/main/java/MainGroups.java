public class MainGroups {

    public static void main(String[] args) {
        //1. Chcę rozbić d czynniki pierwsze - część przed małpą, część po małpie i kraj (po ostatniej kropce)
        String emailAddress1 = "test@gmail.com";
        String emailAddress2 = "jan@interia.wp.pl";
        printTab(splitEmailAddress(emailAddress1));
        printTab(splitEmailAddress(emailAddress2));
        //2. Chcę sformatować numer telefonu do postaci 123-123-123
        String phoneNumber = "123-41 2 322";
        System.out.println(phoneNumberFormat(phoneNumber));
        phoneNumberFormat(phoneNumber);
        //3. Ze zdania chcę wyciągnąć drugie słowo, ale może składać się tylko z liter
        String someSentence = "To jest jakies zdanie";
        System.out.println(secondWord(someSentence));
    }

    public static String[] splitEmailAddress(String emailAddress){
        String[] emailAddressSplitByAt = emailAddress.split("[@]");
        String beforeAt = emailAddressSplitByAt[0];
        String[] emailAddressSplitAfterAtByDot = emailAddressSplitByAt[1].split("\\.");
        String country = emailAddressSplitAfterAtByDot[emailAddressSplitAfterAtByDot.length-1];
        StringBuilder afterAtBeforeCountry = new StringBuilder();
        for (int i = 0; i < emailAddressSplitAfterAtByDot.length-2; i++) {
            afterAtBeforeCountry.append(emailAddressSplitAfterAtByDot[i]);
            afterAtBeforeCountry.append(".");
        }
        afterAtBeforeCountry.append(emailAddressSplitAfterAtByDot[emailAddressSplitAfterAtByDot.length-2]);
        String afterAt = afterAtBeforeCountry.toString();
        String[] emailAddressSplitted = {beforeAt,afterAt,country};
        return emailAddressSplitted;
    }

    public static void printTab(String[] tab){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tab[0] + ",");
        for (int i = 1; i < tab.length-1; i++) {
            stringBuilder.append(" " + tab[i] + ",");
        }
        stringBuilder.append(" " + tab[tab.length-1]);
        System.out.println(stringBuilder);
    }

    public static String phoneNumberFormat(String phoneNumber){
        String[] phoneNumberSplit = phoneNumber.split("[ -]");
        StringBuilder phoneNumberMatch = new StringBuilder();
        for (int i = 0; i < phoneNumberSplit.length; i++) {
            phoneNumberMatch.append(phoneNumberSplit[i]);
        }
        String phoneNumberMatched = phoneNumberMatch.toString();
        char[] phoneNumberToCharArray = phoneNumberMatched.toCharArray();
        StringBuilder phoneNumberFormat = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            phoneNumberFormat.append(phoneNumberToCharArray[i]);
        }
        phoneNumberFormat.append("-");
        for (int i = 3; i < 6; i++) {
            phoneNumberFormat.append(phoneNumberToCharArray[i]);
        }
        phoneNumberFormat.append("-");
        for (int i = 6; i < 9; i++) {
            phoneNumberFormat.append(phoneNumberToCharArray[i]);
        }
        return phoneNumberFormat.toString();
    }

    public static String secondWord(String someSentence){
        String[] sentenceSplit = someSentence.split("[ +]");
        return sentenceSplit[1];
    }
}
