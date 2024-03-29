package local.learning.common.models.expense

import kotlinx.datetime.Instant
import local.learning.common.INSTANT_NEGATIVE_INFINITY
import local.learning.common.INSTANT_POSITIVE_INFINITY
import local.learning.common.models.card.CardGuid
import java.math.BigDecimal

data class ExpenseSearchFilter(
    var amountFrom: BigDecimal = BigDecimal.valueOf(-1),
    var amountTo: BigDecimal = BigDecimal.valueOf(-1),
    var dateFrom: Instant = INSTANT_NEGATIVE_INFINITY,
    var dateTo: Instant = INSTANT_POSITIVE_INFINITY,
    var sources: List<CardGuid> = mutableListOf()
)