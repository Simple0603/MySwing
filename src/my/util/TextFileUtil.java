package my.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by shaofa on 2017/11/15.
 */

public class TextFileUtil
{
	/** 读取一个文本文件
	 * 
	 * @param file 文件路径
	 * @param charset 该文件采用的字符集，一般为 "UTF-8" 或者 "GBK"
	 */
    public static String read( File file, String charset) throws Exception
    {
        FileInputStream fstream = new FileInputStream(file);
        try{
            int fileSize = (int)file.length();
            if(fileSize > 1024*512)
                throw new Exception("File too large to read! size=" + fileSize);

            byte[] buffer = new byte[ fileSize ];
            int n = fstream.read(buffer);
            
            // detect utf-8 bom bytes
            int off = 0;
            int len = n;
            if(buffer[0] == (byte)0xef && buffer[1] == (byte)0xbb && buffer[2] == (byte)0xbf)
            {
            	off += 3;
            	len -= 3;
            }
            return new String(buffer, off, len , charset);
            
        }finally
        {
            try{ fstream.close();}catch (Exception e){}
        }
    }

    /** 将文本保存到文件
     * 
     * @param file 文件的路径
     * @param text 文本
     * @param charset 字符集编码，一般为 "UTF-8" 或者 "GBK"
     */
    public static void write(File file, String text, String charset) throws Exception
    {
        FileOutputStream fstream = new FileOutputStream(file);
        try{
            fstream.write( text.getBytes( charset ));
        }finally
        {
            fstream.close();
        }
    }
}
