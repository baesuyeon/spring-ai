package com.study.spring_ai.config

import mu.KLogging
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAiConfig(
    @Value("\${spring.ai.openai.api-key}") private val apiKey: String,
) {

    @Bean
    fun openAiApi(): OpenAiApi {
        logger.debug { "OpenAI API client initialized" }
        return OpenAiApi.builder()
            .apiKey(apiKey)
            .build()
    }

    companion object : KLogging()
}