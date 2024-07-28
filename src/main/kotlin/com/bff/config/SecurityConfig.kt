package com.bff.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun userDetailsService(): UserDetailsService {
        val users: User.UserBuilder = User.withDefaultPasswordEncoder()
        val manager = InMemoryUserDetailsManager()
        manager.createUser(users.username("admin").password("password").roles("ADMIN").build())
        return manager
    }

    @Order(1)
    @Bean
    fun apiFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            cors {  }
            securityMatcher("/admin/**")
            authorizeHttpRequests {
                authorize(anyRequest, hasRole("ADMIN"))
            }
            httpBasic { }
        }
        return http.build()
    }

    @Bean
    fun formLoginFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            cors {  }
            authorizeHttpRequests {
                authorize("/**", permitAll)
            }
            formLogin { }
        }
        return http.build()
    }

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
            }
        }
    }
}
