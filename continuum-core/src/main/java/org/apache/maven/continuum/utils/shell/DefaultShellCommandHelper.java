package org.apache.maven.continuum.utils.shell;

/*
 * Copyright 2004-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;

import org.codehaus.plexus.logging.AbstractLogEnabled;
import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.codehaus.plexus.util.cli.Commandline;

/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @version $Id$
 */
public class DefaultShellCommandHelper
    extends AbstractLogEnabled
    implements ShellCommandHelper
{
    // ----------------------------------------------------------------------
    // ShellCommandHelper Implementation
    // ----------------------------------------------------------------------

    public ExecutionResult executeShellCommand( File workingDirectory,
                                                File executable,
                                                String arguments )
        throws Exception
    {
        Commandline cl = new Commandline();

        Commandline.Argument argument = cl.createArgument();

        argument.setLine( arguments );

        return executeShellCommand( workingDirectory,
                                    executable,
                                    argument.getParts() );
    }

    public ExecutionResult executeShellCommand( File workingDirectory,
                                                File executable,
                                                String[] arguments )
        throws Exception
    {
        // ----------------------------------------------------------------------
        // Make the command line
        // ----------------------------------------------------------------------

        Commandline cl = new Commandline();

        System.out.println( "executable = " + executable );

        cl.setExecutable( executable.getAbsolutePath() );

        cl.setWorkingDirectory( workingDirectory.getAbsolutePath() );

        for ( int i = 0; i < arguments.length; i++ )
        {
            String argument = arguments[ i ];

            cl.createArgument().setValue( argument );
        }

        // ----------------------------------------------------------------------
        //
        // ----------------------------------------------------------------------

        CommandLineUtils.StringStreamConsumer stderr = new CommandLineUtils.StringStreamConsumer();

        CommandLineUtils.StringStreamConsumer stdout = new CommandLineUtils.StringStreamConsumer();

        getLogger().info( "Executing: " + cl );

        getLogger().info( "Working directory: " + workingDirectory.getAbsolutePath() );

        int exitCode = CommandLineUtils.executeCommandLine( cl, stdout, stderr );

        // ----------------------------------------------------------------------
        //
        // ----------------------------------------------------------------------

        String out = stdout.getOutput();

        String err = stderr.getOutput();

        ExecutionResult result = new ExecutionResult( out, err, exitCode );

        return result;
    }
}
