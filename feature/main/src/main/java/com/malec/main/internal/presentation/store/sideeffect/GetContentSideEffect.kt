package com.malec.main.internal.presentation.store.sideeffect

import com.malec.main.internal.presentation.store.action.MainAction
import com.malec.main.internal.presentation.store.state.MainState
import ru.fabit.storecoroutines.SideEffect
import javax.inject.Inject

class GetContentSideEffect @Inject constructor(
) : SideEffect<MainState, MainAction>(
    requirement = { _, action -> action is MainAction.ButtonClick },
    effect = { state, _ ->
        val count = state.clickCount + 1
        val text = "clicked $count"
        MainAction.ContentLoaded(text, count)
    },
    error = { MainAction.Error(it) }
)