package tutorial08.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileEntry {
	private List<FileEntry> children;
	private String name;
	private Directory parentFolder;

	public Directory(String name) {
		this.name = name;
		children = new ArrayList<>();
		parentFolder = null;
	}

	public void addEntry(FileEntry entry) {
		children.add(entry);
		entry.setParent(this);
	}

	public void removeEntry(FileEntry entry) {
		children.remove(entry);
	}

	public void setParent(Directory parent) {
		this.parentFolder = parent;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getFullName() {
		return (parentFolder != null ? parentFolder.getFullName() : "") + getName() + "/";
	}

	@Override
	public int getTotalSize() {
		return children.stream().mapToInt(FileEntry::getTotalSize).sum();
	}

	@Override
	public boolean isFile() {
		return false;
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	public static void main(String[] args) {
		Directory root = new Directory("~");
		File f1 = new File("test.txt", new byte[]{'H', 'E', 'L', 'L', 'O'});
		root.addEntry(f1);
		Directory subFolder = new Directory("folder");
		root.addEntry(subFolder);
		File f2 = new File("bap.txt", new byte[]{'B', 'a', 'p'});
		subFolder.addEntry(f2);
		File f3 = new File("bop.txt", new byte[]{'B', 'o', 'p'});
		subFolder.addEntry(f3);

		System.out.println(String.format("%s: size = %d, path = %s", root.getName(), root.getTotalSize(), root.getFullName()));
		System.out.println(String.format("%s: size = %d, path = %s", f1.getName(), f1.getTotalSize(), f1.getFullName()));
		System.out.println(String.format("%s: size = %d, path = %s", subFolder.getName(), subFolder.getTotalSize(), subFolder.getFullName()));
		System.out.println(String.format("%s: size = %d, path = %s", f2.getName(), f2.getTotalSize(), f2.getFullName()));
		System.out.println(String.format("%s: size = %d, path = %s", f3.getName(), f3.getTotalSize(), f3.getFullName()));
	}
}
