import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1, Input 
		Scanner inputFile = new Scanner(System.in);
		
		System.out.println("The path you want to check:");
		String inputpath = inputFile.nextLine();
		
		System.out.println("Input the unit(KB,MB,GB): ");
		String unit = inputFile.nextLine().toUpperCase();
		
		System.out.println("Input the file size: ");
		long size = inputFile.nextLong();
		
		inputFile.close();
		
		// 2, Normalize the Size
		long normSize = NormalizeSize.normalize(size, unit);
		
		// 3, Find the files
		System.out.println("\nchecking...\n====================");
		List<Path> foundFiles = null;
		Path path = Paths.get(inputpath);
		FileVisitor visitor = new FileVisitor(normSize);
		try {
			Files.walkFileTree(path, visitor);
			foundFiles = visitor.getFoundFiles();
			
			if(foundFiles == null)
			{
				System.out.println("No Files Found");
			}
			else 
			{
				for(Path cur : foundFiles)
				{
					System.out.print(cur.toString());
					System.out.print("  --->"+cur.toFile().length()/(1024*1024) + "MB");
				
					
					if(cur.getFileName().toString().charAt(0)=='.')
						System.out.print("-->*HiddenFile");
					System.out.println("");
				}
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
