
public class NormalizeSize {

	public static long normalize(long size , String unit)
	{
		long finalSize = -1;
		
		if("KB".equals(unit))
			finalSize = size * 1024 ;
		else if("MB".equals(unit))
			finalSize = size * 1024 * 1024;
		else if("GB".equals(unit))
			finalSize = size * 1024 * 1024 * 1024;
		
		return finalSize;
	}
	
}
