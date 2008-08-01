package org.apache.maven.mercury.metadata;

import org.apache.maven.mercury.artifact.ArtifactMetadata;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * Error while retrieving repository metadata from the repository.
 *
 * @author Jason van Zyl
 * @version $Id: MetadataRetrievalException.java 680880 2008-07-29 23:31:21Z ogusakov $
 */
public class MetadataRetrievalException
    extends Exception
{

    private ArtifactMetadata artifact;

    public MetadataRetrievalException( String message )
    {
        this( message, null, null );
    }

    public MetadataRetrievalException( Throwable cause )
    {
        this( null, cause, null );
    }

    public MetadataRetrievalException( String message,
                                       Throwable cause )
    {
        this( message, cause, null );
    }

    public MetadataRetrievalException( String message,
                                       Throwable cause,
                                       ArtifactMetadata artifact )
    {
        super( message, cause );

        this.artifact = artifact;
    }

    public ArtifactMetadata getArtifactMetadata()
    {
        return artifact;
    }
}