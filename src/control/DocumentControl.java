package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.QueryDocument;
import jdbc.UpdateDocument;
import vo.Document;
import vo.Book;
import vo.JournalVolume;
import vo.ConferenceProceeding;
import vo.JournalIssue;

public class DocumentControl {
	public static int newBook(Book book) {
		if (repeatedISBN(book.getIsbn())) {
			return Constant.REPEATED_ISBN;
		}
		if (UpdateDocument.newBook(book) == false) {
			return Constant.UPDATE_FAILED;
		}
		return Constant.UPDATE_SUCCESSFUL;
	}

	public static int newJournalVolume(JournalVolume volume) {
		if (UpdateDocument.newJournalVolume(volume) == false) {
			return Constant.UPDATE_FAILED;
		}
		return Constant.UPDATE_SUCCESSFUL;
	}

	public static int newConferenceProceeding(ConferenceProceeding proceeding) {
		if (UpdateDocument.newConferenceProceeding(proceeding) == false) {
			return Constant.UPDATE_FAILED;
		}
		return Constant.UPDATE_SUCCESSFUL;
	}

	public static List<Document> getDocumentListByConditions(Document document) {
		List<Document> documentList = new ArrayList<>();

		return documentList;
	}

	public static Document getDocumentById(int documentId) {
		Document document = null;

		return document;
	}

	public static Book getBookById(int documentId) {
		Book book = null;

		return book;
	}

	public static Book getBookByISBN(int isbn) {
		Book book = null;

		return book;
	}

	public static List<JournalIssue> getIssueListByVolumeId(int volumeId) {
		List<JournalIssue> issueList = new ArrayList<>();

		return issueList;
	}

	public static JournalVolume getJournalVolumeById(int documentId) {
		JournalVolume volume = null;

		return volume;
	}

	public static ConferenceProceeding getConferenceProceedingById(int documentId) {
		ConferenceProceeding proceeding = null;

		return proceeding;
	}

	private static boolean repeatedISBN(String isbn) {
		ResultSet rs = QueryDocument.getISBN(isbn);
		boolean result = false;
		try {
			if (rs.next()) {
				result = true;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = true;
		}
		return result;
	}

	public static void main(String[] argv) {

	}
}
