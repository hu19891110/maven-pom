package org.apache.maven.mercury.builder.api;

/**
 *
 *
 * @author Oleg Gusakov
 * @version $Id$
 *
 */
public class MetadataReaderException
    extends Exception
{

  /**
   * 
   */
  public MetadataReaderException()
  {
  }

  /**
   * @param message
   */
  public MetadataReaderException( String message )
  {
    super( message );
  }

  /**
   * @param cause
   */
  public MetadataReaderException( Throwable cause )
  {
    super( cause );
  }

  /**
   * @param message
   * @param cause
   */
  public MetadataReaderException( String message, Throwable cause )
  {
    super( message, cause );
  }

}
