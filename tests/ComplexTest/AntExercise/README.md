# Java build tools practical

## Ant
1. Create `build.xml` file in project root directory.
2. Add project information to `build.xml`
    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <project name="MyFileUtils" basedir=".">
    </project>
    ```
    
3. Add description information to `build.xml` inside `project` element
    ```xml
    <description>
       MyFileUtils is a simple utility library for file manipulation.
    </description>
    ```

4. Pick a name for directory where to build your project, e.g. `build` and create 
property for it:
    ```xml
    <property name="build_dir" location="build" />
    ```
    
5. Now you should have
    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <project name="MyFileUtils" basedir=".">
    <description>
        MyFileUtils is a simple utility library for file manipulation.
    </description>

    <property name="build_dir" location="build" />

    </project>
    ```
    
6. Now we need to create our `build` directory. So we need to add some target for this: 
    ```xml
    <target name="init">
        <mkdir dir="${build_dir}"/>
    </target>
    ```

7. Run `ant init` and see what happens

8. Now we need a target for cleaning up:
    ```xml
    <target name="clean">
        <delete dir="${build_dir}" failonerror="false" />
    </target>
    ```

9. Now try to run `ant clean`

10. Add property where the compiled classes should go:
    ```xml
    <property name="classes" location="${build_dir}/classes"/>
    ```
    
11. Modify `init` target to create also `classes` directory.

12. Create property where all our source files are
    ```xml
    <property name="src" location="src" />
    ```

13. Add compilation target
    ```xml
    <target name="compile" depends="init" description="Compile">
        <javac includeantruntime="false" debug="true" destdir="${classes}"
               srcdir="${src}" includes="**/*.java">
        </javac>
    </target>
    ```

14. Try to run `ant compile` and inspect the `classes` directory

15. Add default target for the project
    ```xml
    <project name="MyFileUtils" default="compile" basedir=".">
    ```

16. Now just run `ant` and see what happens

17. Now add some `javadoc` comments for `MyFileUtils.java` (`/** */ above methods, classes etc.`)

18. Add property where documentation should go
    ```xml
    <property name="documentation" location="${build_dir}/documentation" />
    ```

19. Add `documentation` target
    ```xml
    <target name="doc" depends="init"
            description="Generates JavaDoc documentation">
        <mkdir dir="${documentation}"/>
        <javadoc charset="UTF-8" access="public" sourcepath="${src}"
                 destdir="${documentation}"
            Doctitle="MyFileUtils library">
        </javadoc>
    </target>    
    ``` 
    
20. Run `ant doc`, inspect `documentation` directory and open `index.html`

21. Create `package-info.java` in `cz.cuni.mff.fileutils` and add there information about the package, e.g.
    ```java
    /**
     * Contains utility classes for file manipulation.
     */
    package cz.cuni.mff.fileutils;
    ```
    
22. Add `build-jar` target
    ```xml
    <target name="build-jar" depends="init,compile">
        <jar destfile="${build_dir}/MyFileUtils.jar" basedir="${classes}"
             includes="cz/cuni/mff/**/*">
        </jar>
    </target>
    ```
    
23. Run `ant build-jar`

24. run `jar xvf MyFileUtils.jar` and see what happened. Is `jar` signature familiar?