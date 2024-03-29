package local.learning.common

import local.learning.common.log.LoggerProvider
import local.learning.common.repo.ICardRepository
import local.learning.common.repo.IExpenseRepository
import local.learning.common.repo.IPrincipalRepository

data class CorSettings(
    val loggerProvider: LoggerProvider = LoggerProvider(),
    val principalRepo: IPrincipalRepository = IPrincipalRepository.NONE,
    val cardRepoTest: ICardRepository = ICardRepository.NONE,
    val cardRepoProd: ICardRepository = ICardRepository.NONE,
    val expenseRepoTest: IExpenseRepository = IExpenseRepository.NONE,
    val expenseRepoProd: IExpenseRepository = IExpenseRepository.NONE
) {
    companion object {
        val NONE = CorSettings()
    }
}