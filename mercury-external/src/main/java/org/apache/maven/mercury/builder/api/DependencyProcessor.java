package org.apache.maven.mercury.builder.api;

import java.util.List;
import java.util.Map;

import org.apache.maven.mercury.artifact.ArtifactBasicMetadata;

public interface DependencyProcessor
{
  
  public static final DependencyProcessor NULL_PROCESSOR = 
                        new DependencyProcessor() {
                          public List<ArtifactBasicMetadata> getDependencies( 
                                                                    ArtifactBasicMetadata bmd
                                                                  , MetadataReader mdReader
                                                                  , Map env
                                                                  , Map sysProps
                                                                            )
                          throws MetadataReaderException, DependencyProcessorException
                          {
                            return null;
                          }
                        };

  public List<ArtifactBasicMetadata> getDependencies( ArtifactBasicMetadata bmd, MetadataReader mdReader, Map env, Map sysProps )
  throws MetadataReaderException, DependencyProcessorException;
}
