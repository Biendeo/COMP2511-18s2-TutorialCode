package tutorial08.composite;

public interface FileEntry {
	String getName();
	String getFullName();
	int getTotalSize();
	boolean isFile();
	boolean isDirectory();
	void setParent(Directory parent);
}
