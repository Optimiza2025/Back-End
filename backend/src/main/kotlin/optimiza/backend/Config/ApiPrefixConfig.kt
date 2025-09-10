package optimiza.backend.Config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class ApiPrefixConfig : WebMvcConfigurer {
    override fun configurePathMatch(configurer: PathMatchConfigurer) {
        configurer.addPathPrefix("/optimiza") { clazz ->
            // Aplica o prefixo para todos os controllers do seu pacote
            clazz.packageName.startsWith("optimiza.backend.Controller")
        }
    }
}