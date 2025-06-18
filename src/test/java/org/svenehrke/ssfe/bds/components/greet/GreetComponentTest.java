package org.svenehrke.ssfe.bds.components.greet;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.generated.precompiled.DynamicTemplates;
import gg.jte.generated.precompiled.StaticTemplates;
import gg.jte.generated.precompiled.Templates;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class GreetComponentTest {

    @Test
    void justTemplateEngine() {
        CodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src/main/java")); // This is the directory where your .jte files are located.
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html); // Two choices: Plain or Html

        TemplateOutput output = new StringOutput();
        templateEngine.render("root.jte", (Object) null, output);
        System.out.println(output);
    }

    @Nested
    class StaticTemplatesTests {
        @Test
        void without_param() {
            Templates templates = new StaticTemplates();
            String s = templates.orgSvenehrkeSsfeBdsComponentsGreetGreet(new GreetCM(null)).render();
            assertThat(s.replace(System.lineSeparator(), "\n")).isEqualTo("""
            
             {
            <div>Hello world</div>
            }
            
            """.replace(System.lineSeparator(), "\n")
            );
        }

        @Test
        void with_param() {
            Templates templates = new StaticTemplates();
            String s = templates.orgSvenehrkeSsfeBdsComponentsGreetGreet(new GreetCM("Bart")).render();
            assertThat(s.replace(System.lineSeparator(), "\n")).isEqualTo("""
            
             {
            <div>Hello Bart</div>
            }
            
            """.replace(System.lineSeparator(), "\n")
            );
        }

    }

    @Test
    void dynamicTemplates() {
        CodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src/main/java")); // This is the directory where your .jte files are located.
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html); // Two choices: Plain or Html
        Templates templates = new DynamicTemplates(templateEngine);
        TemplateOutput output = new StringOutput();
        String s = templates.orgSvenehrkeSsfeBdsComponentsGreetGreet(new GreetCM("World")).render();
        System.out.println(output);
        assertThat(s.replace(System.lineSeparator(), "\n")).isEqualTo("""
            
             {
            <div>Hello World</div>
            }
            
            """.replace(System.lineSeparator(), "\n")
        );
    }
}
