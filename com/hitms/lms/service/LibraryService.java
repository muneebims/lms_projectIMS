package com.hitms.lms.service;
import com.hitms.lms.exception.BookUnavailableException;

public class LibraryService {
 
    /**
     * Returns the copy count after issuing one copy of title.
     * @throws BookUnavailableException if availableCopies is 0.
     */
    public static int issueBook(int availableCopies, String title) throws BookUnavailableException {
        if (availableCopies <= 0) {
            throw new BookUnavailableException("'" + title + "' has no copies available.");
        }
        return availableCopies - 1;
    }
    public static String findMemberById(String[] members, String targetId) {
    for (String member : members) {
        if (member.equals(targetId)) {
            return member;
        }
    }
    return "Member not found";
}
    public static void main(String[] args) {
        try {
            System.out.println("Remaining copies: " + issueBook(3, "Clean Code"));
            issueBook(0, "Clean Code");
        } catch (BookUnavailableException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
