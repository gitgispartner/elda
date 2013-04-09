package com.epimorphics.lda.support;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 	<p>
 	Glob allows glob-like wildcard expansion in pathnames, specifically the
 	use of * to represent any sequence of non-/ characters. A Glob is 
 	initialised with a FileSystemInterface instance that encapsulates the
 	test for isDirectory() and listing files in a given directory; typically
 	this just falls back to the usual File primitives.
 	</p>
 	
 	<p><b>note</b>
 	Future versions of this class may implement more globbing features.
 	</p>
*/
public class Glob {
	
	/**
	 	The FileSystemInterface for querying the filesystem.
	*/
	protected final FileSystemInterface fs;
	
	/**
	    Initialise this Glob with the default FileSystemInterface.
	*/
	public Glob() {
		this( FileSystemInterface.fsInstance );
	}
	
	/**
	    Initialise this Glob with the specified FileSystemInterface.
	*/
	public Glob(FileSystemInterface fs) {
		this.fs = fs;
	}
	
	/**
	    filesMatching(path) returns a list of all the files whose names match
	    the provided path. "Matching" means that there are replacement
	    strings (not containing /) for each of the '*'s in the path that
	    make the path equal to the filename.
	*/
	public List<File> filesMatching(String path) {
		return filesMatching( new ArrayList<File>(), path );
	}

	/**
	 	filesMatching(files,path) appends to the files list all the files
	 	whose names match the provided path (as above) and returns that
	 	same list.	 	
	*/
	public List<File> filesMatching(List<File> files, String path) {
		String root = "./";
		if (path.startsWith("/")) {
			root = "/"; 
			path = path.substring(1);
		} 
		return filesMatching(files, new File(root), Arrays.asList( path.split("/") ) );	
	}

	private List<File> filesMatching(List<File> files, File root, List<String> segments ) {
		if (segments.isEmpty()) {
			files.add( root );
		} else if (fs.isDirectory(root)) {
			File[] listedFiles = fs.listFiles( root, matching( segments.get(0) ) );
			if (listedFiles != null)
				for (File f: listedFiles ) {
					filesMatching( files, f, segments.subList(1, segments.size() ) );
			}
		} 			
		return files;
	}

	private FilenameFilter matching(String globString) {
		final Pattern p = Pattern.compile( toRegex( globString ) );
		return new FilenameFilter() {
			
			@Override public boolean accept (File f, String name) {
				return p.matcher( name ).matches();
			}
		};
	}

	private String toRegex( String globString ) {
		StringBuilder re = new StringBuilder( globString.length() * 11 / 10 );
		for (int i = 0, limit = globString.length(); i < limit; i += 1) {
			char ch = globString.charAt(i);
			if (ch == '*') re.append('.').append('*');
			else if ("[].*+()?^$\\".indexOf(ch) > -1) re.append("\\").append(ch);
			else re.append(ch);
		}
		return re.toString();
	}	
	
	/**
	    A FileSystemInterface provides an interface onto a file system
	    that allows querying for a name being a directory name and extracting
	    from a directory a list of names that match a given pattern.
	*/
	public interface FileSystemInterface {
		
		/**
		    Returns true if f names a directory.
		*/
		public boolean isDirectory(File f);
		
		/**
		    Returns an array of files that appear in the directory f and
		    which pass the given filename filter.
		*/
		public File [] listFiles(File f, FilenameFilter ff);
		
		/**
		    fsInstance is a FileSystemInterface that uses the .isDirectory and
		    .listFiles methods of File for implementation. 
		*/
		public static final FileSystemInterface fsInstance = new FileSystemInterface() {

			@Override public boolean isDirectory(File f) {
				return f.isDirectory();
			}

			@Override public File[] listFiles(File f, FilenameFilter ff) {
				return f.listFiles(ff);
			}
			
		};
	}
}