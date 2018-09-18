package tutorial08.composite;

import java.util.Arrays;

public class File implements FileEntry {
	private byte[] data;
	private String name;
	private Directory folder;

	public File(String name, byte[] data) {
		this.name = name;
		this.data = data;
		this.folder = null;
	}

	public byte[] read() {
		return Arrays.copyOf(data, data.length);
	}

	public void setParent(Directory parent) {
		this.folder = parent;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getFullName() {
		return (folder != null ? folder.getFullName() : "") + getName();
	}

	@Override
	public int getTotalSize() {
		return data.length;
	}

	@Override
	public boolean isFile() {
		return true;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}
}
