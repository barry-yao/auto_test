package com.kodak.selenium.icw.enums;


public enum FileListStyles {
	List, Thumbs, Grid, Spread;

	public String getMenuItemClassName() {
		return String.format("iconFile%sDark-enabled", this.name());
	}

	public String getDropdownClassName() {
		return String.format("iconFile%s-enabled", this.name());
	}

	public String getListViewClassName() {
		String key = this.name().toLowerCase();
		if (this == FileListStyles.Thumbs)
			key = "thumbnail";
		return String.format("fileItems_%s", key);
	}

	@Override
	public String toString() {
		return String.format("menu:%s, dropdown:%s, listView:", this.getMenuItemClassName(), this.getDropdownClassName(),
				this.getListViewClassName());
	}

	public static FileListStyles parse(String className) {
		for (FileListStyles style : FileListStyles.values()) {
			if(style.toString().contains(className)){
				return style;
			}
		}
		return null;

	}

}
