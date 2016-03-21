import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


public class FileVisitor extends SimpleFileVisitor<Path>{
	
	private long checkSize;
	private List<Path> findFile = new ArrayList<Path>();
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		// TODO Auto-generated method stub
		
		if(attrs.size() >= checkSize)
		{
			//System.out.println(file.getFileName() + "-->" + attrs.size()/1024+"KB");
			findFile.add(file);
		}
			
		
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		// TODO Auto-generated method stub
		System.out.println(exc.toString());
		return FileVisitResult.CONTINUE;
	}
	
	
	//-----------------------------
	public FileVisitor(long checkSize) {
		// TODO Auto-generated constructor stub
		this.checkSize = checkSize;
	}
	
	public List<Path> getFoundFiles()
	{
		return this.findFile;
	}

}
