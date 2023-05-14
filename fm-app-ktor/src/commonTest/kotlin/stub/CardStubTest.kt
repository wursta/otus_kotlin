package local.learning.app.ktor.stub

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import local.learning.api.models.*
import local.learning.api.serialization.utils.jsonSerializer
import local.learning.common.models.card.Card
import local.learning.stubs.CardStub
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CardStubTest {
    private val cardStub: Card = CardStub.get()
    @Test
    fun create() = testApplication {
        val response = client.post("/api/card/create") {
            val requestObj = CardCreateRequestDto(
                requestId = "uniqueRequestId",
                requestType = "cardCreate",
                card = CardCreateObjectDto(
                    number = cardStub.number,
                    validFor = cardStub.validFor,
                    owner = cardStub.owner,
                    bank = cardStub.bankGuid.asString()
                )
            )
            contentType(ContentType.Application.Json)
            val requestJson = jsonSerializer.encodeToString(requestObj)
            setBody(requestJson)
        }
        val responseJson = response.bodyAsText()
        val responseObj = jsonSerializer.decodeFromString<CardCreateResponseDto>(responseJson)
        assertEquals(200, response.status.value)
        assertEquals("cardCreate", responseObj.responseType)
        assertEquals(ResponseResultDto.SUCCESS, responseObj.result)
        assertNull(responseObj.errors)
        assertEquals(cardStub.guid.asString(), responseObj.card?.guid)
        assertEquals(cardStub.number, responseObj.card?.number)
        assertEquals(cardStub.validFor, responseObj.card?.validFor)
        assertEquals(cardStub.owner, responseObj.card?.owner)
        assertEquals(cardStub.bankGuid.asString(), responseObj.card?.bank?.guid)
    }

    @Test
    fun read() = testApplication {
        val response = client.post("/api/card/read") {
            val requestObj = CardReadRequestDto(
                requestId = "uniqueRequestId",
                requestType = "cardRead",
                guid = cardStub.guid.asString()
            )
            contentType(ContentType.Application.Json)
            val requestJson = jsonSerializer.encodeToString(requestObj)
            setBody(requestJson)
        }
        val responseJson = response.bodyAsText()
        val responseObj = jsonSerializer.decodeFromString<CardReadResponseDto>(responseJson)
        assertEquals(200, response.status.value)
        assertEquals("cardRead", responseObj.responseType)
        assertEquals(ResponseResultDto.SUCCESS, responseObj.result)
        assertNull(responseObj.errors)
        assertEquals(cardStub.guid.asString(), responseObj.card?.guid)
        assertEquals(cardStub.number, responseObj.card?.number)
        assertEquals(cardStub.validFor, responseObj.card?.validFor)
        assertEquals(cardStub.owner, responseObj.card?.owner)
        assertEquals(cardStub.bankGuid.asString(), responseObj.card?.bank?.guid)
    }

    @Test
    fun update() = testApplication {
        val response = client.post("/api/card/update") {
            val requestObj = CardUpdateRequestDto(
                requestId = "uniqueRequestId",
                requestType = "cardCreate",
                card = CardObjectDto(
                    guid = cardStub.guid.asString(),
                    number = cardStub.number,
                    validFor = cardStub.validFor,
                    owner = cardStub.owner,
                    bank = BankObjectDto(
                        guid = cardStub.bankGuid.asString()
                    )
                )
            )
            contentType(ContentType.Application.Json)
            val requestJson = jsonSerializer.encodeToString(requestObj)
            setBody(requestJson)
        }
        val responseJson = response.bodyAsText()
        val responseObj = jsonSerializer.decodeFromString<CardCreateResponseDto>(responseJson)
        assertEquals(200, response.status.value)
        assertEquals("cardUpdate", responseObj.responseType)
        assertEquals(ResponseResultDto.SUCCESS, responseObj.result)
        assertNull(responseObj.errors)
        assertEquals(cardStub.guid.asString(), responseObj.card?.guid)
        assertEquals(cardStub.number, responseObj.card?.number)
        assertEquals(cardStub.validFor, responseObj.card?.validFor)
        assertEquals(cardStub.owner, responseObj.card?.owner)
        assertEquals(cardStub.bankGuid.asString(), responseObj.card?.bank?.guid)
    }

    @Test
    fun delete() = testApplication {
        val response = client.post("/api/card/delete") {
            val requestObj = CardDeleteRequestDto(
                requestId = "uniqueRequestId",
                requestType = "cardCreate",
                guid = cardStub.guid.asString()
            )
            contentType(ContentType.Application.Json)
            val requestJson = jsonSerializer.encodeToString(requestObj)
            setBody(requestJson)
        }
        val responseJson = response.bodyAsText()
        val responseObj = jsonSerializer.decodeFromString<CardDeleteResponseDto>(responseJson)
        assertEquals(200, response.status.value)
        assertEquals("cardDelete", responseObj.responseType)
        assertEquals(ResponseResultDto.SUCCESS, responseObj.result)
        assertNull(responseObj.errors)
        assertEquals(cardStub.guid.asString(), responseObj.card?.guid)
        assertEquals(cardStub.number, responseObj.card?.number)
        assertEquals(cardStub.validFor, responseObj.card?.validFor)
        assertEquals(cardStub.owner, responseObj.card?.owner)
        assertEquals(cardStub.bankGuid.asString(), responseObj.card?.bank?.guid)
    }
}